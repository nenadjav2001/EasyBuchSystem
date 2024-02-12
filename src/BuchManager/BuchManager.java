package BuchManager;

import java.time.LocalDate;
import java.time.LocalTime;

public class BuchManager {


    private int bookId;
    private String autor;
    private LocalDate localDate;
    private LocalTime localTime;
    private String nameBuch;

    public BuchManager(int bookId , String autor , LocalDate localDate , LocalTime localTime , String nameBuch){

    this.bookId = bookId;
    this.autor = autor;
    this.localDate = localDate;
    this.localTime = localTime;
    this.nameBuch = nameBuch;
    }

   public int getBookId(){
        return bookId;
   }
  public String getAutor(){
        return autor;
  }
  public LocalDate getLocalDate(){
        return localDate;
  }
  public LocalTime getLocalTime(){
        return localTime;
  }
   public String getNameBuch(){
        return nameBuch;
   }

   public void setBookId(int bookId){
        this.bookId = bookId;
   }
   public void setAutor(String autor){
        this.autor = autor;
   }
  public void setLocalDate(LocalDate localDate){
        this.localDate = localDate;
  }
  public void setLocalTime(LocalTime localTime){
        this.localTime = localTime;
  }
  public void setNameBuch(String nameBuch){
        this.nameBuch = nameBuch;
  }





}
