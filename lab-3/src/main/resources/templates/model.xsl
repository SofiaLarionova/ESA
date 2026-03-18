<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>CvModel Details</title>
            </head>
            <body>
                <h1>CvModel Details</h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <td>
                            <xsl:value-of select="CvModel/id"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Title</th>
                        <td>
                            <xsl:value-of select="CvModel/modelName"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Genre</th>
                        <td>
                            <xsl:value-of select="CvModel/releaseDate"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Year</th>
                        <td>
                            <xsl:value-of select="CvModel/top5Score"/>
                        </td>
                    </tr>
                </table>
                <div style="text-align: left; margin-top: 20px;">
                    <a href="/models/xsl">View All CV Models</a>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
