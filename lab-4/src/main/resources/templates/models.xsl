<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Computer Vision Model List</title>
                <style>
                    table {
                    border-collapse: collapse;
                    width: 80%;
                    margin: 20px auto;
                    }
                    th, td {
                    border: 1px solid #ddd;
                    padding: 8px;
                    text-align: center;
                    }
                    th {
                    background-color: #f2f2f2;
                    }
                    tr:nth-child(even) {
                    background-color: #f9f9f9;
                    }
                    tr:hover {
                    background-color: #f1f1f1;
                    }
                </style>
            </head>
            <body>
                <h1 style="text-align: center;">CV Model List</h1>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Release Date</th>
                            <th>Score</th>
                            <th>Link</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="ArrayList/item">
                            <tr>
                                <td>
                                    <xsl:value-of select="id"/>
                                </td>
                                <td>
                                    <xsl:value-of select="modelName"/>
                                </td>
                                <td>
                                    <xsl:value-of select="releaseDate"/>
                                </td>
                                <td>
                                    <xsl:value-of select="top5Score"/>
                                </td>
                                <td>
                                    <a>
                                        <xsl:attribute name="href">
                                            <xsl:text>/models/xsl/</xsl:text>
                                            <xsl:value-of select="id"/>
                                        </xsl:attribute>
                                        View CV-Model
                                    </a>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
