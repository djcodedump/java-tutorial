<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<!--
An XSL style sheet consists of one or more set of rules that are called templates
A template contains rules to apply when a specified node is matched
-->
    <xsl:template match="/">

        <html>
            <body>
                <h1>All Book collection</h1>
                <table border="1">
                    <tr bgcolor="orange">
                        <th>Book</th><th>Category</th><th>Author</th><th>Year</th><th>Price</th>
                    </tr>
                    <xsl:for-each select="bookstore/book">
                        <xsl:sort select="author"/>
                        <tr>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="@category"/></td>
                            <td><xsl:value-of select="author"/></td>
                            <td><xsl:value-of select="year"/></td>
                            <td>$<xsl:value-of select="price"/></td>
                        </tr>
                    </xsl:for-each>
                </table>

                <br/>
                <h1>Web Catalog</h1>
                <table border="1">
                    <tr bgcolor="yellow">
                        <th>Book</th><th>Category</th><th>Author</th>
                    </tr>
                    <xsl:for-each select="bookstore/book[@category='web']">
                        <tr>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="@category"/></td>
                            <td><xsl:value-of select="author"/></td>
                        </tr>
                    </xsl:for-each>
                </table>

                <br/>
                <h1>Children Catalog</h1>
                <table border="1">
                    <tr bgcolor="skyblue">
                        <th>Book</th><th>Category</th><th>Author</th>
                    </tr>
                    <xsl:for-each select="bookstore/book">
                        <xsl:if test="@category='children'">
                        <tr>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="@category"/></td>
                            <td><xsl:value-of select="author"/></td>
                        </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>

                <br/>
                <h1>Books above $30.0</h1>
                <table border="1">
                    <tr bgcolor="pink">
                        <th>Book</th><th>Category</th><th>Author</th><th>Price</th>
                    </tr>
                    <xsl:for-each select="bookstore/book[price &gt;= 30]">
                        <tr>
                            <td><xsl:value-of select="title"/></td>
                            <td><xsl:value-of select="@category"/></td>
                            <td><xsl:value-of select="author"/></td>
                            <td>$<xsl:value-of select="price"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>

    </xsl:template>

</xsl:stylesheet>
