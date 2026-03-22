import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "accounts")
public class PostVersion {

    @DatabaseField
    private String Id,PostTypeId,AcceptedAnswerId,ParentId,CreationDate,DeletionDate,Score,ViewCount,Body,OwnerUserId,OwnerDisplayName,LastEditorUserId,LastEditorDisplayName,LastEditDate,LastActivityDate,Title,Tags,AnswerCount,CommentCount,FavoriteCount,ClosedDate,CommunityOwnedDate,Count,Modified,oriText,modifiedText,position,operation,similarity;

    PostVersion() {
        // all persisted classes must define a no-arg constructor with at least package visibility
    }

    public PostVersion(String id, String postTypeId, String acceptedAnswerId, String parentId, String creationDate, String deletionDate, String score, String viewCount, String body, String ownerUserId, String ownerDisplayName, String lastEditorUserId, String lastEditorDisplayName, String lastEditDate, String lastActivityDate, String title, String tags, String answerCount, String commentCount, String favoriteCount, String closedDate, String communityOwnedDate, String count, String modified, String oriText, String modifiedText, String position, String operation, String similarity) {
        Id = id;
        PostTypeId = postTypeId;
        AcceptedAnswerId = acceptedAnswerId;
        ParentId = parentId;
        CreationDate = creationDate;
        DeletionDate = deletionDate;
        Score = score;
        ViewCount = viewCount;
        Body = body;
        OwnerUserId = ownerUserId;
        OwnerDisplayName = ownerDisplayName;
        LastEditorUserId = lastEditorUserId;
        LastEditorDisplayName = lastEditorDisplayName;
        LastEditDate = lastEditDate;
        LastActivityDate = lastActivityDate;
        Title = title;
        Tags = tags;
        AnswerCount = answerCount;
        CommentCount = commentCount;
        FavoriteCount = favoriteCount;
        ClosedDate = closedDate;
        CommunityOwnedDate = communityOwnedDate;
        Count = count;
        Modified = modified;
        this.oriText = oriText;
        this.modifiedText = modifiedText;
        this.position = position;
        this.operation = operation;
        this.similarity = similarity;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPostTypeId() {
        return PostTypeId;
    }

    public void setPostTypeId(String postTypeId) {
        PostTypeId = postTypeId;
    }

    public String getAcceptedAnswerId() {
        return AcceptedAnswerId;
    }

    public void setAcceptedAnswerId(String acceptedAnswerId) {
        AcceptedAnswerId = acceptedAnswerId;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String parentId) {
        ParentId = parentId;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public String getDeletionDate() {
        return DeletionDate;
    }

    public void setDeletionDate(String deletionDate) {
        DeletionDate = deletionDate;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getViewCount() {
        return ViewCount;
    }

    public void setViewCount(String viewCount) {
        ViewCount = viewCount;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getOwnerUserId() {
        return OwnerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        OwnerUserId = ownerUserId;
    }

    public String getOwnerDisplayName() {
        return OwnerDisplayName;
    }

    public void setOwnerDisplayName(String ownerDisplayName) {
        OwnerDisplayName = ownerDisplayName;
    }

    public String getLastEditorUserId() {
        return LastEditorUserId;
    }

    public void setLastEditorUserId(String lastEditorUserId) {
        LastEditorUserId = lastEditorUserId;
    }

    public String getLastEditorDisplayName() {
        return LastEditorDisplayName;
    }

    public void setLastEditorDisplayName(String lastEditorDisplayName) {
        LastEditorDisplayName = lastEditorDisplayName;
    }

    public String getLastEditDate() {
        return LastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        LastEditDate = lastEditDate;
    }

    public String getLastActivityDate() {
        return LastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        LastActivityDate = lastActivityDate;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public String getAnswerCount() {
        return AnswerCount;
    }

    public void setAnswerCount(String answerCount) {
        AnswerCount = answerCount;
    }

    public String getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(String commentCount) {
        CommentCount = commentCount;
    }

    public String getFavoriteCount() {
        return FavoriteCount;
    }

    public void setFavoriteCount(String favoriteCount) {
        FavoriteCount = favoriteCount;
    }

    public String getClosedDate() {
        return ClosedDate;
    }

    public void setClosedDate(String closedDate) {
        ClosedDate = closedDate;
    }

    public String getCommunityOwnedDate() {
        return CommunityOwnedDate;
    }

    public void setCommunityOwnedDate(String communityOwnedDate) {
        CommunityOwnedDate = communityOwnedDate;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public String getModified() {
        return Modified;
    }

    public void setModified(String modified) {
        Modified = modified;
    }

    public String getOriText() {
        return oriText;
    }

    public void setOriText(String oriText) {
        this.oriText = oriText;
    }

    public String getModifiedText() {
        return modifiedText;
    }

    public void setModifiedText(String modifiedText) {
        this.modifiedText = modifiedText;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
}
