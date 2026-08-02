class Solution {
    public String simplifyPath(String path) {
       Stack<String> stack = new Stack<>();
        
        // Split by "/"
        String[] parts = path.split("/");
        
        for (String part : parts) {
            
            // Ignore empty and "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            
            // Handle ".."
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory name
                stack.push(part);
            }
        }
        
        // Build final path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        // If empty, return root
        return result.length() == 0 ? "/" : result.toString();
    }
}