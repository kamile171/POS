# Instruction how to test APIs

## Implemented URLs and their request bodies:

### item
- Add a new item to the inventory
POST http://localhost:8080/item

{
  "id": 799,
  "itemName": "soap",
  "cost": 1.99,
  "discountPercentage": 78.9
}

- Update an existing item
PUT http://localhost:8080/item

{
  "id": 799,
  "itemName": "soap",
  "cost": 1.99,
  "discountPercentage": 78.9
}

- Finds Items by criteria
GET http://localhost:8080/item/criteria
Keys: itemName (String), cost (BigDecimal), discountPercentage (Double)

- Find all items in inventory
GET http://localhost:8080/items

- Find item by ID
GET http://localhost:8080/item/{itemId}

- Delete an item
DELETE http://localhost:8080/item/{itemId}

### order

- Add a new order
POST http://localhost:8080/order

{
    "id": 3,
    "registerId": 777,
    "itemId": 111,
    "totalValue": 99.5,
    "dateTime": "2019-02-05T22:08:28.097832",
    "paymentMethod": "cash",
    "isInactive": true,
    "loyalty": 2.56,
    "orderComment": "Order made by beauty salon.",
    "items": [
        799,
        864,
        555
    ]
}

- Update an existing order
PUT http://localhost:8080/order

{
    "id": 3,
    "registerId": 777,
    "itemId": 111,
    "totalValue": 99.5,
    "dateTime": "2019-02-05T22:08:28.097832",
    "paymentMethod": "cash",
    "isInactive": true,
    "loyalty": 2.56,
    "orderComment": "Order made by beauty salon.",
    "items": [
        799,
        864,
        555
    ]
}

- Finds Order by criteria
GET http://localhost:8080/order/criteria
Keys: isInactive (Boolean), orderComment (String), items (Long[])

- Find all orders
GET http://localhost:8080/orders

- Find order by ID 
GET http://localhost:8080/order/{orderId}

- Delete an order
DELETE http://localhost:8080/order/{orderId}

### staff

- Get all staff members
GET http://localhost:8080/staff

- Update an existing staff member
PUT http://localhost:8080/staff/{staffId}

{
  "name": "Jackie",
  "surname": "Chan",
  "dateOfEntrance": "2025-09-18 17:32:28",
  "totalHoursWorked": "10000",
  "role": "Manager"
}

- Add a new staff member
POST http://localhost:8080/staff

{
  "name": "John",
  "surname": "Smith",
  "dateOfEntrance": "2022-07-25 17:32:28",
  "totalHoursWorked": "34",
  "role": "Manager"
}

- Find staff member by ID
GET http://localhost:8080/staff/{staffId}

- Delete a staff member by ID
DELETE http://localhost:8080/staff/{staffId}

- Update staff member role
PUT http://localhost:8080/staff/{staffId}/role

Waiter

(!!to update staff member role, put his ID in url and send desired role as simple string, just the word!!)

### subscription

- Find all subscriptions
GET http://localhost:8080/subscriptions

- Add a new subscription
POST http://localhost:8080/subscriptions

{"businessName": "Some Business", "daysUntilNextPayment": 30, "paymentAmount":"199.99"}

- Update an existing subscription
PUT http://localhost:8080/subscriptions

{"businessId":1, "businessName": "Some Business", "daysUntilNextPayment": 15, "paymentAmount":"199.99"}

- Find subscription by ID
GET http://localhost:8080/subscription/{businessId}

- Delete a subscription
DELETE http://localhost:8080/subscription/{businessId}

### cashRegister

- Update a cash register entry
PUT http://localhost:8080/cashregister

{"registerId": 1, "businessId": 1, "currentCashierId": 1, "totalEarnings":"199.99", "transactionCount": 1, "cashInRegister":"199.99", "preferredCurrency":"Eur"}

- Add a new cash register
POST http://localhost:8080/cashregister

{"businessId": 1, "currentCashierId": 1, "totalEarnings":"199.99", "transactionCount": 1, "cashInRegister":"199.99", "preferredCurrency":"Eur"}

- Get a cash register by register ID
GET http://localhost:8080/cashregister/{registerId}

- Delete a cash register entry
DELETE http://localhost:8080/cashregister/{registerId}

- Get all cash register entries
GET http://localhost:8080/cashregisters

- Find cash registers by the business id
GET http://localhost:8080/cashregisters/business/{businessId}

### fault

- Find all faults
GET http://localhost:8080/faults

- Add a new fault
POST http://localhost:8080/fault

{
  "urgency": "urgency_text",
  "description": "description_text",
  "staffId": "1"
}

- Update an existing fault
PUT POST http://localhost:8080/fault/{faultId}

{
  "urgency": "urgency_text",
  "description": "description_text",
  "staffId": "1"
}

- Find fault by ID
GET http://localhost:8080/fault/{faultId}

- Delete a fault
DELETE http://localhost:8080/fault/{faultId}

## a) Using Firefox browser
  1) Run the "jar" file. It should be in the email/.
  2) Open Firefox Browser.
  3) Click Burger menu on the top right.

![image](https://user-images.githubusercontent.com/90321426/210209927-8d5482a5-57cb-4da5-98dd-0e191fadec3f.png)

  4) Navigate to "More tools".

![image](https://user-images.githubusercontent.com/90321426/210210046-f5aa7479-eff0-4be4-a26f-4f64483658bf.png)

  5) Click "Web Developer Tools".

![image](https://user-images.githubusercontent.com/90321426/210210130-1fc53310-b0fa-479f-b81f-85f1e131f095.png)

  6) Go to "Network".

![image](https://user-images.githubusercontent.com/90321426/210210927-78cbda13-a45b-407e-9284-c038e79bbce0.png)

  7) Enter "http://localhost:8080/items" into search box and press "Enter".
     (! if port is incorrect try finding the correct one somewhere in text in the terminal launched by jar)

![image](https://user-images.githubusercontent.com/90321426/210210382-86fcc733-a749-43a2-8282-5775f0f555fd.png)

  8) Click generated request and then press "Response" on the right.
     (Here you can see the response of the request)

![image](https://user-images.githubusercontent.com/90321426/210211100-e2c1fa51-6502-4c40-92e4-4deee8812fff.png)

  9) To make different requests right-click on the request and press "Edit and Resend".

![image](https://user-images.githubusercontent.com/90321426/210211747-35d2530e-1230-4ce7-91c8-b521e61487c3.png)

  10) Here you can change the request as you want. Change type of the request, url. When sending PUT and POST requests add "Content-Type" header and request body.

![image](https://user-images.githubusercontent.com/90321426/210212311-20dfb5b0-01a2-4664-8123-882c5db8734f.png)


## b) Using Postman
  1) Download and install the Postman app https://www.postman.com/downloads/ 
  2) Run PosApplication.main()
  3) In postman go to Workspaces -> My Workspace -> New -> HTTP Request
  
https://user-images.githubusercontent.com/76537530/210276698-840b9cfb-a881-415f-ad8d-a6db1b33fd87.mp4

  4) Test the api :]
  
### Examples:
  a) Post Order
    
https://user-images.githubusercontent.com/76537530/210277169-4f07fd9e-59fd-42d2-9c06-c1438540d0ee.mp4

  b) Get Order by criteria
  
https://user-images.githubusercontent.com/76537530/210277567-9561f181-8638-48d8-8cf1-08b439fa2045.mp4

