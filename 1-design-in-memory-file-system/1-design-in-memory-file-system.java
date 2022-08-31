class FileSystem {
    private Dir rootDir = new Dir();

    public FileSystem() {
        
    }
    
    public List<String> ls(String path) {
        List<String> args = tokenize(path);
        if (args.isEmpty()) {
            return rootDir.ls();
        }
        Dir current = rootDir;
        for (int i = 0; i < args.size() - 1; ++i) {
            current = current.cd(args.get(i));
        }
        Dir subDir = current.cd(args.get(args.size() - 1));
        if (subDir != null) {
            current = subDir;
            return current.ls();
        } else {
            return List.of(args.get(args.size() - 1));
        }
    }
    
    public void mkdir(String path) {
        Dir current = rootDir;
        for (String arg : tokenize(path)) {
            var subDir = current.cd(arg);
            if (subDir == null) {
                current = current.mkdir(arg);
            } else {
                current = subDir;
            }
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        getFile(filePath).append(content);
    }
    
    public String readContentFromFile(String filePath) {
        return getFile(filePath).cat();
    }
    
    private File getFile(String filePath) {
        List<String> args = tokenize(filePath);
        Dir current = rootDir;
        for (int i = 0; i < args.size() - 1; ++i) {
            String subDir = args.get(i);
            current = current.cd(subDir);
        }
        return current.getOrCreateFile(args.get(args.size() - 1));
    }
    
    private List<String> tokenize(String path) {
        List<String> result = new ArrayList<>();
        int start = 0;
        while (true) {
            int idx = path.indexOf('/', start);
            if (idx == -1) {
                String part = path.substring(start, path.length());
                if (!part.isEmpty()) {
                    result.add(part);
                }
                break;
            } else {
                String part = path.substring(start, idx);
                if (!part.isEmpty()) {
                    result.add(part);
                }
                start = idx + 1;
            }
        }
        return result;
    }
    
    private class Dir {
        private final Map<String, Dir> subDirs = new HashMap<>();
        private final Map<String, File> files = new HashMap<>();
        
        Dir cd(String subDir) {
            return subDirs.get(subDir);
        }
        
        Dir mkdir(String name) {
            Dir subDir = new Dir();
            subDirs.put(name, subDir);
            return subDir;
        }
        
        List<String> ls() {
            List<String> result = new ArrayList<>(subDirs.keySet());
            result.addAll(files.keySet());
            Collections.sort(result);
            return result;
        }
        
        File getFile(String fileName) {
            return files.get(fileName);
        }
        
        File getOrCreateFile(String fileName) {
            File file = getFile(fileName);
            if (file == null) {
                file = new File();
                files.put(fileName, file);
            }
            return file;
        }
    }
    
    private class File {
        private StringBuilder contents = new StringBuilder();
        
        String cat() {
            return contents.toString();
        }
        
        void append(String content) {
            contents.append(content);
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
