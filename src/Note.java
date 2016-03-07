public class Note implements java.io.Serializable
{
    public String userName;
    public String note;
    public int operation;
    
    public Note(String username,String userNote, int op)
    {
        userName = username ;
        note = userNote;
        operation = op;
    }
    
    public String getUser()
    {
        return userName;
    }
    
    public String getNotes()
    {
        return note;
    }
    
}
