FROM node:20 as builder

WORKDIR /app

COPY package*.json ./

RUN npm ci

COPY . .

RUN npm run build --prod

FROM nginx:latest

WORKDIR /app

COPY --from=builder /app/dist/paperless-ui /usr/share/nginx/html


COPY conf/nginx.conf /etc/nginx/nginx.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
