FROM nginx
COPY ui /usr/share/nginx/html
COPY ui/cors.conf /etc/nginx/conf.d/cors.conf
EXPOSE 8084
CMD ["nginx", "-g", "daemon off;"]
