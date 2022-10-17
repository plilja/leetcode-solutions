class Solution {
    record Dir(
        String name,
        List<String> files,
        List<Dir> subFolders
    ) {
        Dir(String name) {
            this(name, new ArrayList<>(), new ArrayList<>());
        }
    }
    
    public int lengthLongestPath(String input) {
        Dir dir = parseInput(input);
        int result = dfsFindLongestPath(dir);
        if (result == 0) {
            return 0;
        } else {
            return result - 1;
        }
    }
    
    private int dfsFindLongestPath(Dir dir) {
        int result = 0;
        for (String file : dir.files()) {
            result = Math.max(result, dir.name().length() + 1 + file.length());
        }
        for (Dir subDir : dir.subFolders()) {
            int sub = dfsFindLongestPath(subDir);
            if (sub != 0) {
                result = Math.max(result, dir.name().length() + 1 + sub);
            }
        }
        return result;
    }
    
    private Dir parseInput(String input) {
        String args[] = input.split("\\n");
        Deque<Dir> stack = new ArrayDeque<>();
        Dir rootDir = new Dir("");
        stack.add(rootDir);
        int prevDepth = 0;
        for (int i = 0; i < args.length; ++i) {
            String arg = args[i];
            int argDepth = 0;
            while (arg.startsWith("\t")) {
                argDepth++;
                arg = arg.substring(1);
            }
            for (int j = 0; j < prevDepth - argDepth; ++j) {
                stack.pollLast();
            }
            prevDepth = argDepth;
            Dir currentDir = stack.peekLast();
            if (currentDir == null) {
                throw new IllegalArgumentException("popped all dirs");
            }
            if (arg.contains(".")) {
                // file
                currentDir.files().add(arg);
            } else {
                // directory
                Dir next = new Dir(arg);
                currentDir.subFolders().add(next);
                stack.add(next);
                prevDepth++;
                
            }
        }
        return rootDir;
    }
}
