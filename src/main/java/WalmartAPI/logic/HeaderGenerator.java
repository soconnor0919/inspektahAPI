/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King
 *
 * Names: O'Connor, Sean
 *        Sanders, Alec
 *        Gaines, Geoffrey
 *        Finkler, Aidan
 *
 * Project: csci205_final_project
 * Package: WalmartAPI.logic
 * Class: HeaderGenerator
 *
 * Description:
 * A class that generates the required headers
 * for the Walmart API REST calls.
 * ****************************************
 */

package WalmartAPI.logic;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.nio.charset.StandardCharsets;
import java.security.KeyRep;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.*;

/**
 * A class that generates the required headers
 * for the Walmart API REST calls.
 */
public class HeaderGenerator {
    /**
     * HashMap containing the generated headers
     */
    private final Map<String, String> map;

    public HeaderGenerator() throws IOException {
        this.map = new HashMap<>();
        generateHeaders(map);
    }

    /**
     * Canonicalizes the given headers.
     *
     * @param headersToSign the headers to canonicalize
     * @return an array containing the canonicalized header names and values
     * @author Walmart API Developers
     */
    protected static String[] canonicalize(Map<String, String> headersToSign) {
        StringBuffer canonicalizedStrBuffer = new StringBuffer();
        StringBuffer parameterNamesBuffer = new StringBuffer();
        Set<String> keySet = headersToSign.keySet();

        // Create sorted key set to enforce order on the key names
        SortedSet<String> sortedKeySet = new TreeSet<String>(keySet);
        for (String key : sortedKeySet) {
            Object val = headersToSign.get(key);
            parameterNamesBuffer.append(key.trim()).append(";");
            canonicalizedStrBuffer.append(val.toString().trim()).append("\n");
        }
        return new String[]{parameterNamesBuffer.toString(), canonicalizedStrBuffer.toString()};
    }

    /**
     * Reads in a file from the resources folder, and
     * stores it as a string
     *
     * @param fileName File to read in
     * @return string containing file content
     * @author sso005
     */
    private static String readFileFromResources(String fileName) {
        // Use the class loader to get the resource stream
        try (InputStream inputStream = HeaderGenerator.class.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new IOException("File not found: " + fileName);
            }

            // Use a Scanner to read the contents of the file
            try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\A")) {
                return scanner.hasNext() ? scanner.next() : "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Extract a private key from a string containing the
     * standard header and footer of a private key file.
     *
     * @param input string containing .pem file data
     * @return trimmed private key
     * @author sso005
     */
    private static String extractPrivateKey(String input) {
        // Find the indices of the begin and end markers
        int beginIndex = input.indexOf("-----BEGIN PRIVATE KEY-----");
        int endIndex = input.indexOf("-----END PRIVATE KEY-----");

        // Check if both markers are found
        if (beginIndex != -1 && endIndex != -1) {
            // Extract the content between the markers
            return input.substring(beginIndex + "-----BEGIN PRIVATE KEY-----".length(), endIndex).trim();
        } else {
            return input; // Return the original input if markers are not found
        }
    }

    /**
     * Generates headers for API request using
     * given consumerId, key version, and
     * generated private key.
     *
     * @param map HashMap to store headers in
     */
    public void generateHeaders(Map<String, String> map) throws IOException {
        String consumerId = readFileFromResources("/walmart-api/consumer-id");
        String key = extractPrivateKey(readFileFromResources("/walmart-api/private-key.pem"));
        String privateKeyVersion = "1";

        long intimestamp = System.currentTimeMillis();

        map.put("WM_CONSUMER.ID", consumerId);
        map.put("WM_CONSUMER.INTIMESTAMP", Long.toString(intimestamp));
        map.put("WM_SEC.KEY_VERSION", privateKeyVersion);

        String[] array = canonicalize(map);

        String data = null;

        try {
            data = generateSignature(key, array[1]);
            map.put("WM_SEC.AUTH_SIGNATURE", data);
        } catch (Exception e) {
        }
    }

    /**
     * Generates a signature for the given string using the provided key.
     *
     * @param key          the key to use to generate the signature
     * @param stringToSign the string to sign
     * @return the generated signature
     * @throws Exception if there is an error generating the signature
     * @author Walmart API Developers
     */
    public String generateSignature(String key, String stringToSign)

            throws Exception {
        Signature signatureInstance = Signature.getInstance("SHA256WithRSA");

        ServiceKeyRep keyRep = new ServiceKeyRep(KeyRep.Type.PRIVATE, "RSA", "PKCS#8", Base64.decodeBase64(key));

        PrivateKey resolvedPrivateKey = (PrivateKey) keyRep.readResolve();

        signatureInstance.initSign(resolvedPrivateKey);

        byte[] bytesToSign = stringToSign.getBytes(StandardCharsets.UTF_8);
        signatureInstance.update(bytesToSign);
        byte[] signatureBytes = signatureInstance.sign();

        String signatureString = Base64.encodeBase64String(signatureBytes);

        return signatureString;
    }

    /**
     * Returns a HashMap containing all required headers
     * to be added to the REST API call.
     *
     * @return map containing headers
     * @author sso005
     */
    public Map<String, String> getHeaders() {
        return map;
    }

    /**
     * A representation of a service key.
     *
     * @author Walmart API Developers
     * @see KeyRep
     */
    public class ServiceKeyRep extends KeyRep {

        private static final long serialVersionUID = -7213340660431987616L;

        /**
         * Creates a new service key representation.
         *
         * @param type      the type of the key
         * @param algorithm the algorithm used to encode the key
         * @param format    the format of the encoded key
         * @param encoded   the encoded key
         * @author Walmart API Developers
         */
        public ServiceKeyRep(Type type, String algorithm, String format, byte[] encoded) {
            super(type, algorithm, format, encoded);
        }

        /**
         * Resolves the key object.
         *
         * @return the resolved key object
         * @throws ObjectStreamException if there is an error resolving the key object
         * @author Walmart API Developers
         */
        protected Object readResolve() throws ObjectStreamException {
            return super.readResolve();
        }
    }
}