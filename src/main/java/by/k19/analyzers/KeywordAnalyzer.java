package by.k19.analyzers;

abstract class KeywordAnalyzer implements TextAnalyzer{
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.toLowerCase().contains(keyword.toLowerCase()))
                return getLabel();
        }
        return Label.OK;
    }
}
