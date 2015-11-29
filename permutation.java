// Copyright 2015 Koji Nobumoto
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.


package RecursivePermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class permutation {
	private static List<String> itemList = new ArrayList(Arrays.asList("0"
																		, "1"
																		, "2"
																		, "3"
																		, "4"
																		, "5"
																		, "6"
																		, "7"
																		, "8"
																		, "9"
																		, "#"
																		, "*"));
	
	private static int cnt = 0;
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(String item : itemList) {
			List<String> tmpItemList = new ArrayList<String>();
			for ( int i=0; i < itemList.size(); i++) {
				if ( item != itemList.get(i)) {
					tmpItemList.add(itemList.get(i));
				}
			}
			calPermtt(item, tmpItemList);
		}
		long endTime = System.currentTimeMillis();
		long differenceTime = endTime - startTime;
		System.out.println("It took " + TimeUnit.MILLISECONDS.toSeconds(differenceTime) + " seconds.");
	}
	
	public static void calPermtt(String res, List<String>itemL){

		if (itemL.size() > 0) {

			for ( String item : itemL) {
				List<String> tmpItemL = new ArrayList<String>();
				for ( int j=0; j < itemL.size(); j++) {
					if ( res != itemL.get(j) && item != itemL.get(j)) {
						tmpItemL.add(itemL.get(j));
					}
				}

				// call me recursively
				calPermtt(res+item, tmpItemL);

			}
		} else {
			cnt++;
			System.out.println("cnt : " + cnt + ", res : "+ res);
		}
	}
}
