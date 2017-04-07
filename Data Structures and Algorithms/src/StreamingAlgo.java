/*The Frequent Algorithm

Here's a simple description of Misra-Gries' Frequent algorithm. 
Demaine (2002) and others have optimized the algorithm, 
but this gives you the gist.

Specify the threshold fraction, 1 / k; 
any item that occurs more than n / k times will be found.
 Create an an empty map (like a red-black tree); 
 the keys will be search terms, and the values will be a counter for that term.

Look at each item in the stream.

If the term exists in the map, increment the associated counter.

Otherwise, if the map less than k - 1 entries,
 add the term to the map with a counter of one.
 
However, if the map has k - 1 entries already, 
decrement the counter in every entry. 

If any counter reaches zero during this process, remove it from the map.

Note that you can process an infinite amount of data with a fixed amount of storage
 (just the fixed-size map). 
 The amount of storage required depends only on the threshold of interest
 , and the size of the stream does not matter.

*/
public class StreamingAlgo {

}
