package object;

import java.util.Date;

/**
 * Created by admin on 2019/4/23.
 */
public class Paper {

    private Date date;

    private String title;

    public Paper(Date date,String title){
        this.date = date;
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question question){

    }

    public void deleteQuestion(int id){

    }

}
