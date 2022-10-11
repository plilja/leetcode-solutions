class Solution {
    fun numUniqueEmails(emails: Array<String>): Int {
        val unique = HashSet<String>()
        for (email in emails) {
            unique.add(normalize(email))
        }
        return unique.size
    }

    private fun normalize(email: String) : String {
        var (local, domain) = email.split("@")
        val plus = local.indexOf("+")
        if (plus != -1) {
            local = local.substring(0, plus)
        }
        local = local.replace(".", "")
        return "$local@$domain"
    }
}