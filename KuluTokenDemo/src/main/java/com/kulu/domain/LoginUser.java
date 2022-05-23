package com.kulu.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alibaba.fastjson.annotation.JSONField;

public class LoginUser implements UserDetails {

	private User user;

	// 存儲權限信息
	private List<String> permissions;
	
	// redis 因為安全性原故不會將下面成員變數序列化導致運行時報錯。
	// 以下成員變量可以經【permissions】反序列化後轉換獲得，因此可以排除存入 redis
	// 存儲 SpringSecurity 所需要的權限信息集合
	@JSONField(serialize = false)	// 序列化忽略的注解
	private List<SimpleGrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		// 以下判斷式為優化代碼，第一次訪問之後信息存入上面成員變數後就可以直接返回信息。
		if(authorities != null) {
			return authorities;
		}
		
		// 把【permissions】中【String】類型的權限信息封裝成【SimpleGrantedAuthority】物件(權限信息集合轉換)
		// java 8 before
//		authorities = new ArrayList<>();
//		// 歷遍 permissions
//		for(String permission : permissions) {
//			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
//			// 將封裝後的信息合併至新的集合回傳
//			authorities.add(authority);
//		}
		//	java 8 after
		authorities = permissions.stream()
				// 因為這裡涉及到元素類型的轉換所以使用【map】方法，
				// 又因為元素轉換使用到【SimpleGrantedAuthority】建構方法，【map】方法內直接可以引用建構式
				.map(SimpleGrantedAuthority::new)
				// 轉換完之後在收集成集合
				.collect(Collectors.toList());
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// 判斷是否未過期
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 是否沒有超時
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 標示為是否可用
		return true;
	}

	
	
	
	public LoginUser() {
//		super();
	}

	public LoginUser(User user) {
//		super();
		this.user = user;
	}

	public LoginUser(User user, List<String> permissions) {
//		super();
		this.user = user;
		this.permissions = permissions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "LoginUser [user=" + user + ", permissions=" + permissions + "]";
	}
}
