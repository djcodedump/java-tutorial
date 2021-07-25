<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h1>Plants in the waterpark</h1>
                <ul>
                    <xsl:for-each select="waterpark/plants/plant">
                        <li>
                            <xsl:value-of select="." /> --> <xsl:value-of select="@water" />
                        </li>
                    </xsl:for-each>
                </ul>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

