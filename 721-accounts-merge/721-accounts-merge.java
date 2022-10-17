import java.util.UUID;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Person, TreeSet<String>> personToEmail = new HashMap<>();
        Map<String, List<Person>> emailToPerson = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            TreeSet<String> emails = new TreeSet<>();
            for (int i = 1; i < account.size(); ++i) {
                String email = account.get(i);
                emails.add(email);
            }
            Person person = new Person(name, UUID.randomUUID().toString());
            personToEmail.put(person, emails);
            for (String email : emails) {
                emailToPerson.computeIfAbsent(email, k -> new ArrayList<>()).add(person);
            }
        }
        
        Map<Person, Set<Person>> personGroup = new HashMap<>();
        for (List<String> account : accounts) {
            for (int r = 1; r < account.size(); ++r) {
                String email = account.get(r);
                List<Person> persons = emailToPerson.get(email);
                
                Person p1 = persons.get(0);
                Set<Person> group = personGroup.computeIfAbsent(p1, k -> new HashSet<>());
                group.add(p1);
                for (int i = 1; i < persons.size(); ++i) {
                    Person p2 = persons.get(i);
                    Set<Person> otherGroup = personGroup.computeIfAbsent(p2, k -> new HashSet<>());
                    otherGroup.add(p2);
                    if (group != otherGroup) {
                        for (Person p : otherGroup) {
                            group.add(p);
                            personGroup.put(p, group);
                        }
                    }
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (Set<Person> group : new HashSet<>(personGroup.values())) {
            TreeSet<String> emails = new TreeSet<>();
            String name = null;
            for (Person p : group) {
                name = p.name();
                emails.addAll(personToEmail.get(p));
            }
            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(emails);
            result.add(list);
        }
        return result;
    }
    
    record Person(String name, String uuid) implements Comparable<Person> {
        @Override
        public int compareTo(Person other) {
            if (!name.equals(other.name)) {
                return name.compareTo(other.name);
            } else {
                return uuid.compareTo(other.uuid);
            }
        }
    }
}
