package edu.ouc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.ouc.dao.AddressDao;
import edu.ouc.pojo.Address;
import edu.ouc.service.AddressService;
import org.springframework.stereotype.Service;

/**
 * @author Marson
 * @date 2024/8/1
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressDao, Address> implements AddressService {
}
