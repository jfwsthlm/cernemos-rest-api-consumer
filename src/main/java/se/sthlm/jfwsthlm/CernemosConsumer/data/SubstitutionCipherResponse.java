package se.sthlm.jfwsthlm.CernemosConsumer.data;

import java.util.Map;

public class SubstitutionCipherResponse
{
    String substitutedText;

    public SubstitutionCipherResponse(String substitutedText)
    {
        this.substitutedText = substitutedText;
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
