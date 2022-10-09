# invoice-system
This is Harri task
**Included the source code and sql file for inserting dummy data
Also includes Postman Collection for testing**

Implemented the two requiered APIs :

# /create-invoice
This API takes a customerId,EmployeeId,Date createdAt,boolean isPaid,List of invoiceItems (every invoiceItem contains itemID , quantity) **in JSON format as a request body**
Json example :


    {
        "customerId": "2",
        "employeeId": "2",
        "createdAt": "2022-10-07",
        "isPaid": "true",
        "invoiceItems": [{
            "itemId": "1",
            "quantity": "2"
        },{
            "itemId": "3",
            "quantity": "5"
        }]
    }

If create invoice was succeful the API return a JSON with some extra information, such as:



    {
        "id": 13,
        "customerId": 2,
        "customerEmail": "afe@sv.com",
        "employeeId": 2,
        "employeeName": "test2 test2",
        "createdAt": "2022-10-07T00:00:00.000+00:00",
        "isPaid": true,
        "invoiceItems": [
            {
                "id": 15,
                "quantity": 5,
                "invoiceId": 13,
                "itemId": 3
            },
            {
                "id": 14,
                "quantity": 2,
                "invoiceId": 13,
                "itemId": 1
            }
        ]
    }

If any of these does not exist in the database this API will return 404 with a text describes the problem.

# /report
This API takes three request parameters as follows :
- employeeId
- startDate
- endDate

Date format is yyyy-MM-dd

returns a list of dates in range (startDate,endDate)where this employee has made any invoices in, with each date the number of invoices made by that employee that day and the number of all items(not the quantity) sold by that employee.
example request:
`/report?employeeId=1&startDate=2022-10-07&endDate=2022-10-10`
result example : 


    [
        {
            "date": "2022-10-07",
            "invoiceCount": 1,
            "totalItems": 4
        },
        {
            "date": "2022-10-09",
            "invoiceCount": 2,
            "totalItems": 5
        }
    ]

if employee does not exist or the date format is wrong it returns Not_Found , Bad_Request respectively. 



