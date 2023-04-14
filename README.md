# coindeskAPI

# Java:8

# 資料庫:H2 Spring Data JPA

# 功能簡述:
呼叫coindesk API，解析其下行內容與資料轉換，並實作新的API。coindesk API:https://api.coindesk.com/v1/bpi/currentprice.json
建立一張幣別與其對應中文名稱的資料表(需附建立SQL語法)，並提供查詢/新增/修改/刪除功能API。 此應用程式的實作內容包括：
幣別DB維護功能。
呼叫coindesk的API。
呼叫coindesk的API，並進行資料轉換，組成新API。此新API提供： A. 更新時間(時間格式範例:1990/01/01 00:00:00)。 B. 幣別相關資訊(幣別、幣別中文名稱以及匯率)。
以下是各項功能之單元測試：

測試呼叫查詢幣別對應表資料API，並顯示其內容。
測試呼叫新增幣別對應表資料API。
測試呼叫更新幣別對應表資料API，並顯示其內容。
測試呼叫刪除幣別對應表資料API。
測試呼叫coindesk API，並顯示其內容。
測試呼叫資料轉換的API，並顯示其內容。
