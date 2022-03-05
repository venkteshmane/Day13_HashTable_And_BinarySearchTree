package HashTable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
public class UC2_FrequencyOfWordsInALargeParagraphPhrase {

	public static void main(String[] args) {
		String string =“Paranoids are not paranoid because they are paranoid but because they keep putting themselves
		        deliberately into paranoid avoidable situations”;

		        ConcurrentMap<String, Integer> freqMap =
		                asList(string.split("[\\s.]"))
		                        .parallelStream()
		                        .filter(s -> !s.isEmpty())
		                        .collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
		        System.out.println(freqMap.toString());

		        //Priority queue that uses frequency as the comparator and size as 3
		        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
		        for (String key : freqMap.keySet()) {
		            pq.add(key);
		            if (pq.size() > 3) {
		                pq.poll();
		            }
		        }
		        String hashCode;
		        System.out.println(hashCode);
		    }
		}
