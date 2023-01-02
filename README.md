#Instruction how to test APIs

a) ##Using Firefox browser
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


###Implemented URLs and their request bodies:

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

[
  {
    "id": 799,
    "itemName": "soap",
    "cost": 1.99,
    "discountPercentage": 78.9
  }
]

- Find all items in inventory
GET http://localhost:8080/items

- 

b) ##Using Postman
