package ma.enset.tprestapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListArticleResonse {
    @SerializedName("totalResults")
    private int totalCount;
    @SerializedName("articles")
    private List<Article> articles;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Article> getUsers() {
        return articles;
    }

    public void setUsers(List<Article> articles) {
        this.articles = articles;
    }
}
