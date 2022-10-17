class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Parts = version1.split("\\.");
        String[] version2Parts = version2.split("\\.");
        for (int i = 0; i < Math.max(version1Parts.length, version2Parts.length); ++i) {
            int version1Part = 0;
            if (i < version1Parts.length) {
                version1Part = Integer.parseInt(version1Parts[i]);
            }
            int version2Part = 0;
            if (i < version2Parts.length) {
                version2Part = Integer.parseInt(version2Parts[i]);
            }
            if (version1Part != version2Part) {
                if (version1Part < version2Part) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }
}
