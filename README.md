# Legal and General Group 5 Project
The project uses Spring Boot using a build tool Gradle-Groovy 

## To setup the project 
Before running any of the steps below please ensure you have **`Node`** installed
Firstly install tailwindcss by running `npm install` at the root of the project
## Thymeleaf and Tailwind
To inherit tailwind css to different html files, include this code in the head part of your file `<link th:replace="~{base :: css_file}"/>`
## To run the project
- First start the tailwindcss compiler by running `npm run tailwind` at the root of the project
## Contributing to the project
- include the following links on your header of the project in order to access the favicon
`<link th:replace="~{base :: favicon}">`
- To include the user navbar on your page , paste the following on top of your body html element
`<div th:replace="sidebar :: sidebarFragment"></div>`
## Helpful resources
- want to learn more about tailwind check this [TailwindCSS Tutorial](https://www.codeinwp.com/blog/tailwind-css-tutorial/) out.
- [TailwindCSS Docs](https://tailwindcss.com/docs/utility-first)
- [Installing pipenv](https://pipenv.pypa.io/en/latest/install/)
- [What is node?](https://www.codecademy.com/article/what-is-node)
- [What is npm?](https://nodejs.org/en/knowledge/getting-started/npm/what-is-npm/)
