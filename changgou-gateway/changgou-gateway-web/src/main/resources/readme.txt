- id: changgou_goods_route
          #uri: http://192.168.64.64:18081
          #lb代表负载均衡，changgou_service_goods微服务的名称
          uri: http://localhost:18081
          #路由规则配置
          predicates:
            #- Path=/api/album/**,/api/brand/**,/api/cache/**,/api/categoryBrand/**,/api/category/**,/api/para/**,/api/pref/**,/api/sku/**,/api/spec/**,/api/spu/**,/api/stockBack/**,/api/template/**
            - Path=/api/goods/**
          filters:
            #- PrefixPath=/brand
            #请求路径中去掉一个前缀，/api
            - StripPrefix=1
            - name: RequestRateLimiter
              args:
                #判别用户身份的唯一识别的处理器
                key-resolver: "#{@ipKeyResolver}"
                redis-rate-limiter.replenishRate: 1
                redis-rate-limiter.burstCapacity: 1