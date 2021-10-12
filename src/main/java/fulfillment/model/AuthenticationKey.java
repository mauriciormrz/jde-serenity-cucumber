package fulfillment.model;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static fulfillment.constants.Constants.*;

public class AuthenticationKey {

    private final String method;
    private final String path;

    private long epoch;
    private String hash;

    public AuthenticationKey(String method, String path) {

        this.method = method;
        this.path = path;
        generateKey();
    }

    public String getPath() {

        return path;
    }

    public long getEpoch() {

        return epoch;
    }

    public String getHash() {

        return hash;
    }

    private void generateKey() {

        epoch = (long) Math.floor((System.currentTimeMillis() / 1000));
        String toSign = method + "|" + URL + path + '|' + epoch;
        String fullKey = PUBLIC_KEY_PRO_STAR + PRIVATE_KEY_PRO_STAR;

        try {
            byte[] toSignBytes = toSign.getBytes(StandardCharsets.UTF_8);
            byte[] keyBytes = fullKey.getBytes(StandardCharsets.UTF_8);
            byte[] signedBytes = calcHmacSha256(keyBytes, toSignBytes);
            hash = Base64.getEncoder().encodeToString(signedBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static private byte[] calcHmacSha256(byte[] secretKey, byte[] message) {

        byte[] hmacSha256;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate hmac-sha256", e);
        }
        return hmacSha256;
    }


    public static final class Builder {
        private String method;
        private String path;

        private Builder() {
        }

        public static Builder anAuthenticationKey() {

            return new Builder();
        }

        public Builder withMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder withPath(String path) {
            this.path = path;
            return this;
        }

        public AuthenticationKey build() {

            return new AuthenticationKey(method, path);
        }
    }
}