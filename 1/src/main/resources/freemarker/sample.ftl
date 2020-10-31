<html>
    <head>
        <title>우리나라 증상</title>
    </head>
    <style>  
        body { background: #fff; }
        .bluetop {
          border-collapse: collapse;
          border-top: 3px solid #168;
        }  
        .bluetop th {
          color: #168;
          background: #f0f6f9;
        }
        .bluetop th, .bluetop td {
          padding: 10px;
          border: 1px solid #ddd;
        }
.bluetop th:first-child, .bluetop td:first-child {
          border-left: 0;
        }
        .bluetop th:last-child, .bluetop td:last-child {
          border-right: 0;
        }
    </style>
    <body>
        <table class="bluetop">
            <th>도시</th>
            <th>걸린사람</th>
            <th>날짜</th>
            <#list message as value>
            <tr>
                <td>${value.city}</td>
                <td>${value.comfirmed}</td>
                <td>${value.date}</td>
            </tr>
            </#list>
        </table>
    </body>
</html>