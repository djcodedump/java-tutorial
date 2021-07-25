<?xml version="1.0" encoding="UTF-8" ?>
<xsl:transform version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" />
    <xsl:template match="/">
        <html>
            <body>
                <h1>All Book collection</h1>
                <table border="1">
                    <tr bgcolor="orange">
                        <th>Book</th><th>Category</th><th>Author</th><th>Year</th><th>Price</th>
                    </tr>
                   <xsl:apply-templates select="bookstore/book"/>
                </table>
            </body>
        </html>

    </xsl:template>

    <xsl:template match="bookstore/book[@category='cooking']">
        <tr bgcolor="yellow">
            <td><xsl:value-of select="title"/></td>
            <td><xsl:value-of select="@category"/></td>
            <td><xsl:value-of select="author"/></td>
            <td><xsl:value-of select="year"/></td>
            <td>$<xsl:value-of select="price"/></td>
        </tr>
    </xsl:template>

    <xsl:template match="bookstore/book[@category !='cooking']">
        <tr bgcolor="pink">
            <td><xsl:value-of select="title"/></td>
            <td><xsl:value-of select="@category"/></td>
            <td><xsl:value-of select="author"/></td>
            <td><xsl:value-of select="year"/></td>
            <td>$<xsl:value-of select="price"/></td>
        </tr>
    </xsl:template>


</xsl:transform>
