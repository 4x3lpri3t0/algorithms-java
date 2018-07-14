// https://leetcode.com/problems/encode-and-decode-tinyurl

// Instead of using only numbers as the Base System
// for encoding the URLSs, we make use of a set of
// integers and alphabets to be used for encoding.

import java.util.HashMap;
import java.util.Random;

public class _535_Encode_and_Decode_TinyURL {
    final String TINY_URL = "http://tinyurl.com/";
    final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map = new HashMap<>();
    Random rand = new Random();
    String key = getRand();

    private String getRand() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomNum = rand.nextInt(62);
            sb.append(alphabet.charAt(randomNum));
        }

        return sb.toString();
    }

    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getRand();
        }

        map.put(key, longUrl);

        return TINY_URL + key;
    }

    public String decode(String shortUrl) {
        shortUrl = shortUrl.replace(TINY_URL, "");

        return map.get(shortUrl);
    }
}

// --- Performance Analysis ---

// The number of URLs that can be encoded is quite large in this case,
// nearly of the order (10 + 26 ∗ 2) raised to the power of 6​​.
// [Possible combination of: 10 digits, 52 upper+lower case chars,
// and allocated in 6 positions of the returning string]

// The length of the encoded URLs is fixed to 6 units,
// which is a significant reduction for very large URLs.

// The performance of this scheme is quite good,
// due to a very less probability of repeated same codes generated.

// We can increase the number of encodings possible as well,
// by increasing the length of the encoded strings.
// Thus, there exists a tradeoff between the length of the code
// and the number of encodings possible.

// Predicting the encoding isn't possible in this scheme since random
// numbers are used [MORE SECURE].
