import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }
  
  public void addTitle(String title) {
    if (this.collection.containsKey(title)){
      throw new RuntimeException(title+" is aleady a part of this library's collection");
    }
    this.collection.put(title, true);
    System.out.println(title + " was added to the library collection");
  }
  
  public String removeTitle(String title) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
    if (!this.collection.containsKey(title)){
      throw new RuntimeException("Sorry, "+title+" is not in this library's collection");
    }
    this.collection.remove(title);
    System.out.println(title+" was removed from this library's collection");
    return title; 
  }

  public void checkOut(String title) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("Sorry, "+title+ " is not a part of this library's collection");
    }
    if (this.collection.containsValue(false)) {
      throw new RuntimeException(title + " is already checked out");
    }
    this.collection.replace(title, true, false);
    System.out.println(title +" was succesfully checked out!");
  }

  public void returnBook(String title) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("Sorry, "+title+ " is not a part of this library's collection");
    }
    if (this.collection.containsValue(true)) {
      throw new RuntimeException(title + " is not checked out.");
    }
    this.collection.replace(title, false, true);
    System.out.println(title+" was succesfully returned");
  }

  public boolean containsTitle(String title) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
     if (this.collection.containsKey(title)){
      System.out.println(title+" is in this library's collection");
      return true;
    }
    else {
      System.out.println(title+" is not in this library's collection");
      return false;
    }
  }

  public boolean isAvailable(String title) {
    if (this.collection.size() == 0){
      throw new RuntimeException("Sorry, there are no books in this library's collection");
    }
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("Sorry, "+title+ " is not a part of this library's collection");
    }
    if (this.collection.get(title) == true) {
      System.out.println(title+" is available!");
      return true;
    }
    else {
      System.out.println(title + " is not available :(");
      return false;
    }
    
  }

  public void printCollection() {
    System.out.println("Titles in this Collection:");
    System.out.println(this.collection.toString()
                          .replace("{", " ")
                          .replace("=",":")
                          .replace(",", "\n")
                          .replace("true", " Available")
                          .replace("false", " Unavailable")
                          .replace("}", ""));
      
    
  }

  public static void main(String[] args) {
    Library myLibrary = new Library("Neilson", "Smith College", 4);
    myLibrary.addTitle("The Hobbit");
    //myLibrary.addTitle("The Hobbit");
    //myLibrary.removeTitle("The Hobbit");
    //myLibrary.removeTitle("The Hobbits");
    //myLibrary.checkOut("The Hobbit");
    //myLibrary.checkOut("The Hobbits");
    //myLibrary.returnBook("The Hobbit");
    //myLibrary.containsTitle("The Hobbit");
    //myLibrary.isAvailable("The Hobbit");
    //myLibrary.addTitle("Lord of the Rings");
    //myLibrary.addTitle("The Silmarillion");
    //myLibrary.printCollection();
  }
  
}


//  ## Phase 2: the `Library` class
//A `Library` is an altogether different kind of building:

//<img src="https://cdn-icons-png.flaticon.com/512/1596/1596485.png" alt="Library icon created by Freepik - Flaticon" width="200"/>

//In this phase, your task is to expand on the stub contained in `Library.java`. A `Library` doesn't have any `residents` (nor do we have to worry about a dining room), but it does have a `collection` (of titles) which we'll store in another data structure called a `Hashtable`:
//```
//private Hashtable<String, Boolean> collection;
//```
//`Hashtable`s are a way to store `(key, value)` pairs in Java. We'll use store each book's title and author (concatenated together as one `String`, i.e. `"The Lorax by Dr. Seuss"`) as the `key`, and we'll use the corresponding boolean value to record whether or not the book is available (`true`) or currently checked out (`false`).

//---
//1. Make the `Library` class `extend` the `Building` class, add a `private Hashtable<String, boolean> collection` attribute, and initialize this to an empty `Hashtable<String, boolean>` inside the `Library` constructor. Don't forget to `import java.util.Hashtable`!

//---
//2. Write methods to update the `Hashtable` containing the `collection` every time we add/remove a title:
//```
//public void addTitle(String title);
//public String removeTitle(String title); // return the title that we removed
//```
//as well as to check a book out or return it (rather than adding or removing a book from the collection, these methods will simply modify the `value` associated with the given `key` - the `title`):
//```
//public void checkOut(String title);
//public void returnBook(String title);
//```
//_Hint: use the functions provided by the [`Hashtable`](https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html) class to make this much easier! Specifically, check out `put(...)`, `remove(...)`, and `replace(...)`._

//---
//3. For good measure, we'll also write a couple of methods to support browsing the collection:
//```
//public boolean containsTitle(String title); // returns true if the title appears as a key in the Libary's collection, false otherwise
//public boolean isAvailable(String title); // returns true if the title is currently available, false otherwise
//public void printCollection(); // prints out the entire collection in an easy-to-read way (including checkout status)
//```
//_Hint: again, let `Hashtable`'s methods do some of the heavy lifting for you!_