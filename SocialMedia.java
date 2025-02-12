package AssignmentLinkList;

import java.util.*;

public class SocialMedia {
    static class Node {
        int userId;
        String name;
        int age;
        List<Integer> friends;
        Node next;

        public Node(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = new ArrayList<>();
            this.next = null;
        }
    }

    private Node head;

    public void addUser(int userId, String name, int age) {
        Node newUser = new Node(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    public Node searchUserById(int userId) {
        Node temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public Node searchUserByName(String name) {
        Node temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int userId1, int userId2) {
        Node user1 = searchUserById(userId1);
        Node user2 = searchUserById(userId2);
        if (user1 != null && user2 != null && !user1.friends.contains(userId2)) {
            user1.friends.add(userId2);
            user2.friends.add(userId1);
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        Node user1 = searchUserById(userId1);
        Node user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friends.remove(Integer.valueOf(userId2));
            user2.friends.remove(Integer.valueOf(userId1));
        }
    }

    public List<Integer> findMutualFriends(int userId1, int userId2) {
        Node user1 = searchUserById(userId1);
        Node user2 = searchUserById(userId2);
        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            for (int friend : user1.friends) {
                if (user2.friends.contains(friend)) {
                    mutualFriends.add(friend);
                }
            }
        }
        return mutualFriends;
    }

    public void displayFriends(int userId) {
        Node user = searchUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friends);
        }
    }

    public void countFriends() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SocialMedia network = new SocialMedia();
        network.addUser(1, "Akansha", 25);
        network.addUser(2, "Hitesh", 30);
        network.addUser(3, "Priya", 27);
        network.addFriendConnection(1, 2);
        network.addFriendConnection(2, 3);
        network.displayFriends(2);
        System.out.println("Mutual friends between akansha and priya: " + network.findMutualFriends(1, 3));
        network.countFriends();
    }
}

