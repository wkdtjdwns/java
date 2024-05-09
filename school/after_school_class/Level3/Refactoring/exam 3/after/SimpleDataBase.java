package removecontrolflag.after;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleDataBase {

    private Map<String, String> map = new HashMap<String, String>();

    public SimpleDataBase(Reader reader) throws IOException {
        
        // Scanner : 저장 공간이 작아서 입출력이 동시에 됨. - 속도가 느림
        // BufferedReader : Buffer = 임시 저장 공간 -> 저장 공간이 큼 - 한 번에 출력하기 때문에 속도가 빠름
        BufferedReader br = new BufferedReader(reader);

        boolean reading = false;
        String line;

        while (!reading) {
            line = br.readLine();
            
            if (line == null) {
                reading = true;
            } else {
                boolean scanningKey = true;

                // String + String 연산 : String값을 새로 만들어서 저장함 -> 비효율적임.
                // StringBuffer : 문자열을 필요할 때에만 저장하고 출력함 -> 효율적임.

                // key와 value 값을 나눠서 저장함.
                StringBuffer keyBuffer = new StringBuffer();
                StringBuffer valueBuffer = new StringBuffer();

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i); // 의미 없는 변수명이라 그냥 c로 선언해도 됨.

                    if (scanningKey) {
                        if(c == '=') {
                            scanningKey = false;
                        } else {
                            keyBuffer.append(c);
                        }
                    } else {
                        valueBuffer.append(c);
                    }
                }

                String key = keyBuffer.toString();
                String value = valueBuffer.toString();
                map.put(key, value);

                // 확실히 이전 코드보다는 코드의 이해가 굉장히 쉬워짐.
            }
        }
    }

    public Iterator<String> iterator() {
        return map.keySet().iterator();
    }

    public String getValue(String key) {
        return map.get(key);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
