
/* Write your PL/SQL query statement below */
SELECT  date_id, make_name,
Count(DISTINCT lead_id) as unique_leads,
cOUNT(distinct partner_id) as unique_partners
from DailySales
Group BY date_id, make_name;