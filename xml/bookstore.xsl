<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>
            <body>
                <h1>My Book collection</h1>
                <table border="1">
                    <tr bgcolor="orange">
                        <th>Book</th>
                        <th>Category</th>
                        <th>Author</th>
                    </tr>
                    <xsl:for-each select="bookstore/book">
                        <tr>
                            <td>
                                <xsl:value-of select="title"/>
                            </td>
                            <td>
                                <xsl:value-of select="@category"/>
                            </td>
                            <td>
                                <xsl:value-of select="author"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>

    </xsl:template>

</xsl:stylesheet>
