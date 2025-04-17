package LibraryManagementSystem;

public class StoryBook extends LibraryItem {
    private String author;

    public StoryBook(String id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getDetails() {
        // TODO Auto-generated method stub
        return "Story Book - ID: " + getId() + ", Title: " + getTitle() + ", Author: " + author;
    }
    
}
