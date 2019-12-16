package com.test.code.tw;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Maps;
import com.test.code.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Map;

public class ThoughtWorks {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws IOException {

        try {
            String inputData = getRequest();
            //System.out.println(inputData);
            Input inputDTO = JsonUtils.convertJSONToObject(inputData, Input.class);

            String text = inputDTO.getText();
            Map<String, Integer> map = Maps.newHashMap();
            map.put("a", 0);
            map.put("e", 0);
            map.put("i", 0);
            map.put("o", 0);
            map.put("u", 0);

            String[] split = text.split("\\s+");
            for (int i = 0; i < split.length; i++) {
                String word = split[i];
                char[] array = word.toCharArray();
                for (int j = 0; j < array.length; j++) {
                    String ss = String.valueOf(array[j]);
                    if (map.containsKey(ss)) {
                        Integer count = map.get(ss);
                        count++;
                        map.put(ss, count);
                    }
                }
            }

            Output output = new Output();

            output.setA(map.get("a"));
            output.setE(map.get("e"));
            output.setI(map.get("i"));
            output.setO(map.get("o"));
            output.setU(map.get("u"));



            String json = JsonUtils.convertObjectToJson(output);
            System.out.println(json);

            postRequest(json);
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

    }


    private static String getRequest() throws IOException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
        SSLSocketFactory sf = new SSLSocketFactory(
                acceptingTrustStrategy, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("https", 443, sf));
        ClientConnectionManager ccm = new PoolingClientConnectionManager(registry);

        StringBuilder stringBuilder = new StringBuilder(StringUtils.EMPTY);
        HttpClient client = new DefaultHttpClient(ccm);
        HttpGet request = new HttpGet("https://http-hunt.thoughtworks-labs.net/challenge/input");
        request.setHeader("userId", "nz9LXf0K");

        request.addHeader("User-Agent", USER_AGENT);
        org.apache.http.HttpResponse response = client.execute(request);

// Get the response
        BufferedReader rd = new BufferedReader
                (new InputStreamReader(
                        response.getEntity().getContent()));

        String line = "";
        while ((line = rd.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    private static void postRequest(String json) throws IOException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
        SSLSocketFactory sf = new SSLSocketFactory(
                acceptingTrustStrategy, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("https", 443, sf));
        ClientConnectionManager ccm = new PoolingClientConnectionManager(registry);

        StringBuilder stringBuilder = new StringBuilder(StringUtils.EMPTY);
        HttpClient client = new DefaultHttpClient(ccm);
        HttpPost request = new HttpPost("https://http-hunt.thoughtworks-labs.net/challenge/output");
        request.setHeader("userId", "nz9LXf0K");
        request.setHeader("Content-Type", "application/json");
        request.addHeader("User-Agent", USER_AGENT);

        StringEntity entity = new StringEntity(json,
                ContentType.APPLICATION_JSON);

        request.setEntity(entity);
        org.apache.http.HttpResponse response = client.execute(request);

        System.out.println(response.getStatusLine().getStatusCode());

    }

    private static String decrypt(Map<Character, Integer> map, String input, Integer offset) {
        StringBuilder stringBuilder = new StringBuilder(StringUtils.EMPTY);
        for (int i = 0; i < input.length(); i++) {
            Character character = Character.valueOf(input.charAt(i));
            if (map.containsKey(character)) {
                Integer index = map.get(character);
                Integer newIndex = 0;
                if (index <= offset) {
                    newIndex = (index + 26) - offset;
                } else {
                    newIndex = index - offset;
                }
                stringBuilder.append(getChar(map, newIndex));
            } else {
                stringBuilder.append(character);
            }
        }

        return stringBuilder.toString();
    }

    private static Character getChar(Map<Character, Integer> map, Integer index) {
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            Integer value = characterIntegerEntry.getValue();
            if (value.equals(index)) {
                return characterIntegerEntry.getKey();
            }
        }
        return null;
    }

    private static void init(Map<Character, Integer> map) {
        int i = 1;
        map.put('A', i++);
        map.put('B', i++);
        map.put('C', i++);
        map.put('D', i++);
        map.put('E', i++);
        map.put('F', i++);
        map.put('G', i++);
        map.put('H', i++);
        map.put('I', i++);
        map.put('J', i++);
        map.put('K', i++);
        map.put('L', i++);
        map.put('M', i++);
        map.put('N', i++);
        map.put('O', i++);
        map.put('P', i++);
        map.put('Q', i++);
        map.put('R', i++);
        map.put('S', i++);
        map.put('T', i++);
        map.put('U', i++);
        map.put('V', i++);
        map.put('W', i++);
        map.put('X', i++);
        map.put('Y', i++);
        map.put('Z', i++);

    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class InputDTO {

        private String encryptedMessage;
        private Integer key;

        public String getEncryptedMessage() {
            return encryptedMessage;
        }

        public void setEncryptedMessage(String encryptedMessage) {
            this.encryptedMessage = encryptedMessage;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "InputDTO{" +
                    "encryptedMessage='" + encryptedMessage + '\'' +
                    ", key=" + key +
                    '}';
        }
    }
}
