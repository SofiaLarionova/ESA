<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Book Details</title>
            </head>
            <body>
                <h1>Book Details</h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <td>
                            <xsl:value-of select="Book/id"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Title</th>
                        <td>
                            <xsl:value-of select="Book/title"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Genre</th>
                        <td>
                            <xsl:value-of select="Book/genre"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Year</th>
                        <td>
                            <xsl:value-of select="Book/year"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Rating</th>
                        <td>
                            <xsl:value-of select="Book/rating"/>
                        </td>
                    </tr>
                </table>
                <div style="text-align: left; margin-top: 20px;">
                    <a href="/books/xsl">View All Books</a>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>