This is a Simple hands on project developed while learning Microservices.
It is a **Assessment Management Dashboard** built using **Microservices with Spring Boot, H2 (In-Memory) Database and Thymeleaf dependency to include HTML pages**.

1. Eureka Server
2. Eureka Server is registered with three microservices.
   * Login
   * Employee Login
   * Admin Login

<img width="1712" alt="Screenshot 2024-11-19 at 12 50 30 PM" src="https://github.com/user-attachments/assets/a0a8c35d-c686-4059-b547-87c60ab0b4e9">

Brief Overview of the functionality.
Login credentials to be entered in the form.


<img width="1706" alt="Screenshot 2024-11-19 at 12 34 39 PM" src="https://github.com/user-attachments/assets/0d87c948-9248-469a-9b76-da2a692161aa">
<img width="1707" alt="Screenshot 2024-11-19 at 12 40 16 PM" src="https://github.com/user-attachments/assets/62774eb0-d025-4982-8898-3a79e0a1b84d">

If the login Credentials are successful, a success message is shown, else a failure message.
<img width="1704" alt="Screenshot 2024-11-19 at 12 40 04 PM" src="https://github.com/user-attachments/assets/8a6f531c-54b6-4f5b-8784-7587318aa55c">
<img width="1716" alt="Screenshot 2024-11-19 at 1 20 45 PM" src="https://github.com/user-attachments/assets/1eb309f4-0019-4425-91f0-64d4a69c317c">


Further, if the userType is Employee, gets connected to employee login microservice, if it is admin, gets connected to adminLogin microservice.


Employee : 

<img width="1708" alt="Screenshot 2024-11-19 at 12 40 37 PM" src="https://github.com/user-attachments/assets/aeb7cedd-6a6d-42b1-aff8-3bf356cfa7e1">
<img width="1712" alt="Screenshot 2024-11-19 at 12 41 23 PM" src="https://github.com/user-attachments/assets/ee1712a4-416d-4086-a8b6-378e2aef2315">
<img width="1706" alt="Screenshot 2024-11-19 at 12 42 55 PM" src="https://github.com/user-attachments/assets/f8d0a8b9-9dc7-469e-8c2d-1aa17028ef1b">
<img width="1709" alt="Screenshot 2024-11-19 at 12 43 01 PM" src="https://github.com/user-attachments/assets/98dd6bb0-5769-4ab0-b111-d3c4b8ddaac9">

Admin:

<img width="1714" alt="Screenshot 2024-11-19 at 12 43 58 PM" src="https://github.com/user-attachments/assets/ec1070a8-6377-4e1e-8f90-40c9cc675c5f">
<img width="1714" alt="Screenshot 2024-11-19 at 12 47 24 PM" src="https://github.com/user-attachments/assets/2a9e020d-5d3f-4f1a-9a1f-e8ff3e96dbe6">
<img width="1713" alt="Screenshot 2024-11-19 at 1 20 29 PM" src="https://github.com/user-attachments/assets/7bbf4a6d-4cf8-4a0b-98aa-9fb67699687c">
