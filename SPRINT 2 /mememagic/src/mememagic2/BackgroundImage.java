/**
 * <h1>BackgroundImage</h1>
 * This is the BackgroundImage class. It has methods that pertain to the image behind the meme and the title. 
 * @author PeterSapountzis
 * @author ZacharyWiel
 * @version 2.0
 * @since 2022-05-03
 */

package mememagic2;
public class BackgroundImage {
    private String imageFileName;
    private String title;
    private String description;


    public BackgroundImage(String imageFileName, String title, String description){
        super();
        this.imageFileName = imageFileName;
        this.title = title;
        this.description = description;
    }

    
    /** 
     * returns name of image file
     * @return String
     */
    public String getImageFileName(){
        return imageFileName;
    }
    
    /** 
     * sets name of image file
     * @param imageFileName
     */
    public void setImageFileName(String imageFileName){
        this.imageFileName = imageFileName;
    }

    
    /** 
     * returns title of meme
     * @return String
     */
    public String getTitle(){
        return title;
    }

    
    /** 
     * sets title of meme
     * @param title
     */
    public void setTitle(String title){
        this.title = title;
    }

    
    /** 
     * returns description of meme
     * @return String
     */
    public String getDescription(){
        return description;
    }

    
    /** 
     * sets description of meme
     * @param description
     */
    public void setDescription(String description){
        this.description = description;
    }

    
    /** 
     * toString
     * @return String
     */
    @Override
    public String toString(){
        String b2 = "<" + description + ">";
        String output = title + " " + b2;
    
        return output;
    }

    
    /** 
     * overriden equals method
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass()!= obj.getClass()){
            return false;
        }
        BackgroundImage oth = (BackgroundImage) obj;
        if (description == null){
            if (oth.description != null){
                return false;
            }
        }
        else if (!description.equals(oth.description)){
            return false;
        }
        if (imageFileName == null){
            if (oth.imageFileName != null){
                return false;
            }
        }
        else if (!imageFileName.equals(oth.imageFileName)){
            return false;
        }
        if (title == null){
            if (oth.title != null){
                return false;
            }
        }
        else if (!title.equals(oth.title)){
            return false;
        }
        return true;
        

    }

}
