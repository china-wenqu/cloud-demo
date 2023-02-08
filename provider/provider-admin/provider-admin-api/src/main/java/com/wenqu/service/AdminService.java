package com.wenqu.service;

import com.wenqu.domain.Admin;

public interface AdminService {

      Admin sentinelTest(String username);
      Admin selectAdminByUsername(String username);
      Integer saveAdmin(Admin admin);
}
