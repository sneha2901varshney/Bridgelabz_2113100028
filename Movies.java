package AssignmentLinkList;

class Doubly
{
    String title;
    String director;
    int year;
    double rating;
    Doubly next;
    Doubly prev;

    public Doubly(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class Movies {
    private Doubly head;
    private Doubly tail;

    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Doubly movie = new Doubly(title, director, year, rating);
        if (head == null) {
            head = tail = movie;
        } else {
            movie.next = head;
            head.prev = movie;
            head = movie;
        }
    }

    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Doubly movie = new Doubly(title, director, year, rating);
        if (tail == null) {
            head = tail = movie;
        } else {
            tail.next = movie;
            movie.prev = tail;
            tail = movie;
        }
    }

    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        Doubly movie = new Doubly(title, director, year, rating);
        Doubly temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addMovieAtEnd(title, director, year, rating);
            return;
        }
        movie.next = temp.next;
        temp.next.prev = movie;
        temp.next = movie;
        movie.prev = temp;
    }

    public void removeMovieByTitle(String title) {
        Doubly temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByDirector(String director) {
        Doubly temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " directed by " + temp.director);
            }
            temp = temp.next;
        }
    }

    public void searchByRating(double rating) {
        Doubly temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " has a rating of " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void displayMoviesForward() {
        Doubly temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayMoviesReverse() {
        Doubly temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        Doubly temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }
}

class MovieManagement {
    public static void main(String[] args) {
        Movies list = new Movies();

        list.addMovieAtEnd("3 Idiots", "Rajkumar Hirani", 2009, 8.4);
        list.addMovieAtEnd("Dangal", "Nitesh Tiwari", 2016, 8.4);
        list.addMovieAtBeginning("Sholay", "Ramesh Sippy", 1975, 8.2);

        System.out.println("Movies List (Forward):");
        list.displayMoviesForward();

        System.out.println("\nMovies List (Reverse):");
        list.displayMoviesReverse();

        System.out.println("\nSearching for movies by Christopher Nolan:");
        list.searchByDirector("Christopher Nolan");

        System.out.println("\nUpdating rating of Inception to 9.0");
        list.updateRating("Inception", 9.0);
        list.displayMoviesForward();
    }
}