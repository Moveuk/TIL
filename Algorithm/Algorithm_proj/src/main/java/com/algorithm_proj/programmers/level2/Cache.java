package com.algorithm_proj.programmers.level2;

public class Cache {
    //캐시 - https://school.programmers.co.kr/learn/courses/30/lessons/17680

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        String[] cache = new String[cacheSize];

        for (String city : cities) {
            boolean isCached = false;
            int indexOfCache = 0;
            if (cacheSize != 0) {
                //cache check
                for (int i = 0; i < cache.length; i++) {
                    if (cache[i] == null) {
                        indexOfCache = i;
                        break;
                    } else if (cache[i].equals(city.toLowerCase())) {
                        //cache hit
                        isCached = true;
                        indexOfCache = i;
                        break;
                    }
                }

                String[] newCache = new String[cacheSize];
                newCache[0] = city.toLowerCase();
                System.arraycopy(cache, 0, newCache, 1, cacheSize - 1);
                if (isCached && indexOfCache + 1 < cacheSize) {
                    System.arraycopy(cache, indexOfCache + 1, newCache, indexOfCache + 1, cacheSize - indexOfCache - 1);
                }

                cache = newCache;

            }

            if (isCached) {
                answer++;
            } else {
                answer += 5;
            }
        }

        return answer;
    }
}
