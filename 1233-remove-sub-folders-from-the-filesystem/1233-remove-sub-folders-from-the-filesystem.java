//the below is a code suggested by me. it was getting a little too complex, so chatGPTed this one. now know what lexicographical order means and is mostly the answer to trie problems ig... let's see Q1 for today!
class Solution {
    public List<String> removeSubfolders(String[] folder) {

        // List to store the final result without subfolders
        List<String> removedSubfolders = new ArrayList<>();

        // Sort the folder paths lexicographically
        Arrays.sort(folder);

        // Variable to track the last added valid parent folder
        String prevFolder = "";

        // Iterate through the sorted folder list
        for (String f : folder) {
            // Check if the current folder is a subfolder of the previous one
            if (prevFolder.isEmpty() || !f.startsWith(prevFolder + "/")) { //note the "!f"  in the second condition here, basically notice the negation, it's important ki NAHI HONA CHAAHIYE
                // If it's not a subfolder, add it to the result
                removedSubfolders.add(f);
                // Update prevFolder to the current folder
                prevFolder = f;
            }
        }

        return removedSubfolders;
    }
}
// class Solution {
//     public List<String> removeSubfolders(String[] folder) {

//         ArrayList<String> removedSubfolders = new ArrayList<>();

//         // Arrays.sort(folder, (s1, s2) -> {
//         //     long count1 = s1.chars().filter(ch -> ch == '/').count();
//         //     long count2 = s2.chars().filter(ch -> ch == '/').count();
//         //     return Long.compare(count1, count2);
//         // });

//         Arrays.sort(folder);

//         for(int i = 0; i < folder.length; i++){
//             System.out.println(folder[i]);
//         }

//         // HashSet<String> folders = new HashSet<>();

//         // int max = folder[0].length();

//         // for(int i = 0; i < folder.length; i++){
//         //     if(!folders.contains(folder[i].substring(0, max))){
//         //         folders.add(folder[i]);
//         //         removedSubfolders.add(folder[i]);
//         //         max = folder[i].length();
//         //         System.out.println(folder[i]);
//         //     }
            
//         // }


//         return removedSubfolders;

//     }
// }
// /*
// steps:
// 1) sort in order of number of "/"
// 2) then add the full strings to a hashset
// 3) check each corresponding string with the hashset (maybe char by char traversal will be required)
// && folder[i].charAt(max + 1) == '/'
// */