package api

enum APIResources {

    addRatingAPI("/candidate-interviews"),
    addCommentAPI("/candidate-interviews"),
    createAIQuestionsAPI("/create-ai-questions"),
    createAITopicsAPI("/create-ai-topics"),
    createFixedInterviewAPI("/create-fixed-interview"),
    createDynamicInterviewAPI("/create-dynamic-interview"),
    draftFixedInterviewAPI("/create-draft-interview"),
    draftDynamicInterviewAPI("/create-draft-dynamic-interview");

    private String resource;
    APIResources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;}
}