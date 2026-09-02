package se.sthlm.jfwsthlm.CernemosConsumer.data;

import java.util.HashMap;
import java.util.Map;

public class SubstitutionCipherForm
{
    String originalText;
    private Map<String, Character> substitutionMap = new HashMap<>();
    String substitutedText;

    public String getOriginalText()
    {
        return originalText;
    }

    public void setOriginalText(String originalText)
    {
        this.originalText = originalText;
    }

    public Map<String, Character> getSubstitutionMap() {
        return substitutionMap;
    }

    public void setSubstitutionMap(Map<String, Character> substitutionMap) {
        this.substitutionMap = substitutionMap;
    }

    public String getSubstitutedText()
    {
        return substitutedText;
    }

    public void setSubstitutedText(String substitutedText)
    {
        this.substitutedText = substitutedText;
    }
}