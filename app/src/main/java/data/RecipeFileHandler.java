package data;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {

        File file = new File(filePath);

        ArrayList<String>readRecipesSplit = new ArrayList<>();
        if(file.exists()){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            
            String line;
            while((line=reader.readLine())!=null){
                
                readRecipesSplit.add(line.split(",",2)[0]);
                readRecipesSplit.add(line.split(",",2)[1]);
            
            }
            
         } catch (IOException e) {
             System.out.println("Error reading file:" + e.getMessage());
         }
         return readRecipesSplit;
        }else{
            
            return null;
        }
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     // 
    public void addRecipe(String recipeName, String ingredients) {
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){
            writer.newLine();
            writer.write(recipeName+","+ingredients);
            System.out.println("Recipe added successfully.");
         } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
         }

         
    }
}
