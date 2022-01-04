package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonUtils {
    /**
     * Метод для получения данных по указанной ссылке
     *
     * @param url - ссылка в виде объекта URL (Uniform Resource Locator)
     * @return содержимое страницы на указанной ссылке в @param url
     */

    public static StringBuilder word = new StringBuilder();

    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        // открываем соедиение к указанному URL
        // помощью конструкции try-with-resources
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            // построчно считываем результат в объект StringBuilder
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            return null;
        }
        return stringBuilder.toString();
    }


    // парсим некоторые данные
    public static void parseCurrentJson(String resultJson) {
        try {
            JSONArray array = new JSONArray(resultJson);

            for (int i = 0; i < array.length(); i++) {

                JSONObject wordJsonObject = new JSONArray(resultJson).getJSONObject(i);
                //System.out.println("word = " + wordJsonObject.getString("word"));
                try {
                    word.append(wordJsonObject.getString("word")).append(",");
                } catch (JSONException e) {
                    word.append(" ").append(",");
                }
                try {
                    //System.out.println("phonetic = " + wordJsonObject.getString("phonetic"));
                    word.append(wordJsonObject.getString("phonetic")).append(", ");
                } catch (JSONException ignored) {
                    word.append(" ").append(",");
                }

                JSONArray meanArray = (JSONArray) wordJsonObject.get("meanings");

                StringBuilder example = new StringBuilder();

                StringBuilder partOfSpeech = new StringBuilder();

                for (int j = 0; j < meanArray.length(); j++) {

                    JSONObject meanJsonObject = new JSONArray(meanArray).getJSONObject(j);
                    try {
                        partOfSpeech.append(meanJsonObject.getString("partOfSpeech")).append(" - ");
                        //System.out.println("mean = " + meanJsonObject.getString("partOfSpeech"));
                    } catch (JSONException ignored) {
                        partOfSpeech.append(" ");
                    }

                    JSONArray definitionsArray = (JSONArray) meanJsonObject.get("definitions");

                    StringBuilder def = new StringBuilder();

                    for (int d = 0; d < definitionsArray.length(); d++) {
                        JSONObject definitionsJsonObject = new JSONArray(definitionsArray).getJSONObject(d);
                        try {
                            def.append(definitionsJsonObject.getString("definition"));
                        } catch (JSONException ignored) {
                            def.append(" ");
                        }
                        try {
                            example.append(definitionsJsonObject.getString("example"));
                        } catch (JSONException ignored) {
                            example.append(" ");
                        }
                    }
                    partOfSpeech.append(def).append("\n");
                }
                word.append("\"").append(partOfSpeech).append("\"").append(",");
                word.append("\"").append(example).append("\"").append("\n");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // создаем объект URL из указанной в параметре строки
    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
